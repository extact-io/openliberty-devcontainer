package io.extact.openliberty.sample.webapi.resource;

import lombok.Getter;

@Getter
public class PersonException extends RuntimeException {
    private CauseError causeError;
    public PersonException(CauseError causeError) {
        this.causeError= causeError;
    }
    public enum CauseError {
        NOT_FOUND,
        DUPLICATE
    }
}
