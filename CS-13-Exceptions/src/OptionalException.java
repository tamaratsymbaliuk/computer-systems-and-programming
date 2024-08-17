import java.util.Collection;
import java.util.Optional;

public class OptionalException {

    private Optional<Double> mean (Collection<Double> numbers) {
        if (numbers.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(numbers.stream().mapToDouble(Double::doubleValue).sum()/ numbers.size());
    }


    }
