package it.unibo.mvc;

import java.util.Map;

/**
 * Encapsulates the concept of configuration.
 */
public final class Configuration {

    private final static String DEFAULT_CON_FILE = "config.yml";

    private final int max; 
    private final int min;
    private final int attempts;

    private Configuration() {
        final ConfigReader reader = new ConfigReader(DEFAULT_CON_FILE);
        final Map<String,Integer> map = reader.mapGen();
        this.max = map.get("maximum");
        this.min = map.get("minimum");
        this.attempts = map.get("attempts");
    }

    /**
     * @return the maximum value
     */
    public int getMax() {
        return max;
    }

    /**
     * @return the minimum value
     */
    public int getMin() {
        return min;
    }

    /**
     * @return the number of attempts
     */
    public int getAttempts() {
        return attempts;
    }

    /**
     * @return true if the configuration is consistent
     */
    public boolean isConsistent() {
        return attempts > 0 && min < max;
    }

    /**
     * Pattern builder: used here because:
     * 
     * - all the parameters of the Configuration class have a default value, which
     * means that we would like to have all the possible combinations of
     * constructors (one with three parameters, three with two parameters, three
     * with a single parameter), which are way too many and confusing to use
     * 
     * - moreover, it would be impossible to provide all of them, because they are
     * all of the same type, and only a single constructor can exist with a given
     * list of parameter types.
     * 
     * - the Configuration class has three parameters of the same type, and it is
     * unclear to understand, in a call to its contructor, which is which. By using
     * the builder, we emulate the so-called "named arguments".
     * 
     */
    public static class Builder {


        private int min;
        private int max;
        private int attempts;
        private boolean consumed = false;

        /**
         * @param min the minimum value
         * @return this builder, for method chaining
         */
        public Builder setMin(final int min) {
            this.min = min;
            return this;
        }

        /**
         * @param max the maximum value
         * @return this builder, for method chaining
         */
        public Builder setMax(final int max) {
            this.max = max;
            return this;
        }

        /**
         * @param attempts the attempts count
         * @return this builder, for method chaining
         */
        public Builder setAttempts(final int attempts) {
            this.attempts = attempts;
            return this;
        }

        /**
         * @return a configuration
         */
        public final Configuration build() {
            if (consumed) {
                throw new IllegalStateException("The builder can only be used once");
            }
            consumed = true;
            return new Configuration();
        }
    }
}

