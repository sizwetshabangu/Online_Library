package library.app.backend.Enums;

import lombok.Getter;

@Getter
public enum TransactionType {
    RENT("Rent"),
    RETURN("Return"),
    LOST("Lost"),
    REPLACE("Replace");

    TransactionType(String displayName) {
        this.displayName = displayName;
    }

    private final String displayName;

}
