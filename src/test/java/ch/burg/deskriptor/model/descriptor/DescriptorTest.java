package ch.burg.deskriptor.model.descriptor;


import ch.burg.deskriptor.model.State;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class DescriptorTest {

    @Test
    public void should_be_able_to_build_descriptor_with_builder() {
        final DiscreteDescriptor discreteDescriptor = DiscreteDescriptor.builder()
                .withName("tail presence")
                .withPossibleStates(new State("yes"), new State("no"))
                .build();

        assertThat(discreteDescriptor.toString()).isEqualTo("DiscreteDescriptor(name=tail presence, possibleSates=[State(name=yes), State(name=no)])");
    }

    @Test
    public void should_be_able_to_build_numerical_descriptor_with_builder() {
        final DiscreteDescriptor discreteDescriptor = DiscreteDescriptor.builder()
                .withName("tail presence")
                .withPossibleStates(new State("yes"), new State("no"))
                .build();

        assertThat(discreteDescriptor.toString()).isEqualTo("DiscreteDescriptor(name=tail presence, possibleSates=[State(name=yes), State(name=no)])");
    }

    @Test
    public void should_be_able_to_build_descriptor_with_no_duplicate_state_using_builder() {
        final DiscreteDescriptor discreteDescriptor = DiscreteDescriptor.builder()
                .withName("tail presence")
                .withPossibleState(new State("yes"))
                .withPossibleState(new State("yes"))
                .withPossibleState(new State("no"))
                .build();

        assertThat(discreteDescriptor.getPossibleSates()).hasSize(2);
        final List<String> stateNameList = discreteDescriptor.getPossibleSates().stream().map(s -> s.getName()).collect(Collectors.toList());
        assertThat(stateNameList).containsExactly("yes", "no");
    }

}