package ch.burg.deskriptor.engine.model.descriptor;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString(exclude = "id")
@EqualsAndHashCode(exclude = "id")
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class NumericalDescriptor implements Descriptor {

    private final String id;
    private final String name;
    private final String measurementUnit;

    public NumericalDescriptor(final Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.measurementUnit = builder.measurementUnit;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public boolean isNumerical() {
        return true;
    }

    @Override
    public boolean isDiscrete() {
        return false;
    }

    public static class Builder {
        private String id;
        private String name;
        private String measurementUnit;

        public Builder withId(final String id) {
            this.id = id;
            return this;
        }

        public Builder withName(final String name) {
            this.name = name;
            return this;
        }

        public Builder withMeasurementUnit(final String measurementUnit) {
            this.measurementUnit = measurementUnit;
            return this;
        }

        public NumericalDescriptor build() {
            return new NumericalDescriptor(this);
        }
    }
}