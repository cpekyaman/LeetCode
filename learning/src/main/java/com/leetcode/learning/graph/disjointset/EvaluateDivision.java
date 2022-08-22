package com.leetcode.learning.graph.disjointset;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class EvaluateDivision {
    public static double[] evaluate(List<List<String>> equations, double[] values, List<List<String>> queries) {
        UnionFind uf = new UnionFind();
        for(int i=0; i<values.length; i++) {
            uf.union(equations.get(i).get(0), equations.get(i).get(1), values[i]);
        }

        double[] results = new double[queries.size()];
        for(int i=0; i<queries.size(); i++) {
            String x = queries.get(i).get(0), y=queries.get(i).get(1);
            if(! uf.exists(x) || !uf.exists(y)) {
                results[i]=-1.0;
            } else {
                results[i]=uf.getEqValue(x,y);
            }
        }
        return results;
    }

    private static final class UnionFind {
        private final Map<String, String> parents;
        private final Map<String, Double> values;

        UnionFind() {
            this.parents = new HashMap<>();
            this.values = new HashMap<>();
        }

        // and equation only has value if x and y are connected (have the same root)
        private double getEqValue(String x, String y) {
            String px=find(x), py=find(y);
            if(px.equals(py)) {
                return values.get(x) / values.get(y);
            }
            return -1.0;
        }

        private boolean exists(String variable) {
            return parents.containsKey(variable);
        }

        // if a->b and b->c before this call
        // a->c with its value updated afterwards
        private String find(String variable) {
            // initially x->x with weight 1.0
            String p = parents.computeIfAbsent(variable, k -> {
                values.put(k, 1.0);
                return k;
            });

            // path compression and value updates from root the backwards
            // value(x -> root) = value(x->y) * value(y->z) ... value(xx->root)
            if(! p.equals(variable)) {
                String parent = find(p);
                values.put(variable, values.get(variable) * values.get(p));
                parents.put(variable, parent);
            }

            return parents.get(variable);
        }

        // initially x->x and y->y
        // then: x->y with value x*y and y->y with value 1
        private void union(String x, String y, double value) {
            String xp = find(x);
            String yp = find(y);

            if(! xp.equals(yp)) {
                parents.put(xp, yp);

                // x/y=value, x/xp=values(x), y/yp=values(y)
                values.put(xp, value * values.get(y) / values.get(x));
            }
        }
    }
}
