package technobel.bart.sandwichspring.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {
    private final Object innerData;

    public NotFoundException(Object innerData) {
        super("Item not found");
        this.innerData = innerData;
    }
}
