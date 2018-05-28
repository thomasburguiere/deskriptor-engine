package ch.burg.deskriptor.model.tree;

import ch.burg.deskriptor.model.State;
import ch.burg.deskriptor.model.descriptor.Descriptor;
import ch.burg.deskriptor.model.descriptor.DiscreteDescriptor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class Node<T extends Treeable> {

    private final T content;
    private final Node<T> parent;
    private final Set<State> inapplicableState;
    private final List<Node<T>> children;

    public Node(final T content,
                final Node<T> parent,
                final Set<State> inapplicableState,
                final List<Node<T>> children) {

        this.content = content;
        this.parent = parent;
        this.inapplicableState = inapplicableState;
        this.children = children;
    }

    public static <T extends Treeable> List<Node<T>> flatTree(final List<T> childrenContent) {

        return childrenContent.stream()
                .map(content -> new Node<>(
                        content,
                        null,
                        null,
                        null))
                .collect(Collectors.toList());

    }

    public static <T extends Treeable> Optional<Node<T>> getNodeContainingContentInList(
            final T content,
            final List<Node<T>> list) {

        return list.stream().filter(n -> n.content.equals(content)).findFirst();
    }

}
