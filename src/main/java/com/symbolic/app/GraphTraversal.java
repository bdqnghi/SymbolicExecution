package com.symbolic.app;


import org.jgrapht.Graph;
import org.jgrapht.ext.DOTImporter;
import org.jgrapht.ext.EdgeProvider;
import org.jgrapht.ext.ImportException;
import org.jgrapht.ext.VertexProvider;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import java.io.*;
import java.nio.file.NoSuchFileException;
import java.util.Map;

/**
 * Created by quocnghi on 24/1/17.
 */
public class GraphTraversal {

    private static final String FILENAME = "E:\\test\\filename.txt";

    public static void main(String[] args) throws FileNotFoundException, ImportException, NoSuchFileException {
//        DirectedGraph<Integer, DefaultEdge> graph = new DefaultDirectedGraph<>(DefaultEdge.class);
//
//        graph.addVertex(7);
//        graph.addVertex(4);
//        graph.addVertex(9);
//        graph.addVertex(3);
//        graph.addVertex(2);
//        graph.addVertex(5);
//
//        graph.addEdge(7, 4);
//        graph.addEdge(7, 9);
//        graph.addEdge(9, 3);
//        graph.addEdge(3, 2);
//        graph.addEdge(3, 5);
//
//        GraphIterator<Integer, DefaultEdge> iterator =
//                new DepthFirstIterator<>(graph);
//        while (iterator.hasNext()) {
//            System.out.println( iterator.next() );
//        }
        GraphTraversal app = new GraphTraversal();
        app.traversal();


    }

    void traversal() throws FileNotFoundException, ImportException, NoSuchFileException {

        Graph<Integer, DefaultEdge> directedGraph =
                new DefaultDirectedGraph<>(DefaultEdge.class);
        VertexProvider<Integer> vertexProvider = new VertexProvider<Integer>() {
            @Override
            public Integer buildVertex(String s, Map<String, String> map) {
                return 12;
            }
        };

        EdgeProvider<Integer, DefaultEdge> edgeProvider = (s, v1, s2, map) -> null;

        DOTImporter<Integer, DefaultEdge> dotImporter = new DOTImporter<Integer, DefaultEdge>(vertexProvider, edgeProvider);

        InputStream is = this.getClass().getResourceAsStream("/cfg.dot");
        if (is == null) {
            throw new NoSuchFileException("Resource file not found. Note that the current directory is the source folder!");
        }

        dotImporter.importGraph(directedGraph, is);
    }
}
