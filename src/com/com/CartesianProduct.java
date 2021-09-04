package com.com;

import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

public class CartesianProduct<T1,T2,VT> {
    protected final Function<Pair<T1,T2>,VT> Map;
    protected final HashMap<Pair<T1,T2>,VT> Matrix;
    protected final List<T1> params1;
    protected final List<T2> params2;
    protected final String content;

    public CartesianProduct(Function<Pair<T1, T2>, VT> map, List<T1> params1, List<T2> params2) {
        String content = new String();
        HashMap<Pair<T1,T2>,VT> Matrix = new HashMap<Pair<T1,T2>,VT>();
        Map = map;
        this.params1 = params1;
        this.params2 = params2;
        for (int i = 0; i < params1.size(); i++) {
            for (int j = 0; j < params2.size(); j++) {
                Matrix.put(new Pair<>(params1.get(i),params2.get(j)),Map.apply(new Pair<>(params1.get(i),params2.get(j))));
                content = content + Matrix.get(new Pair<>(params1.get(i),params2.get(j))).toString() + "\t";
            }
            content = content + "\n";
        }
        this.content = content;
        this.Matrix = Matrix;
    }
    public String getContent() {
        return content;
    }
}
