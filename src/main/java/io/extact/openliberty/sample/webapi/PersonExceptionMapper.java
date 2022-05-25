package io.extact.openliberty.sample.webapi;

import io.extact.openliberty.sample.webapi.resource.PersonException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;

public class PersonExceptionMapper implements ExceptionMapper<PersonException> {
    @Override
    public Response toResponse(PersonException exception) {
        Status status = null;
        switch (exception.getCauseError()) {
            case NOT_FOUND:
                status = Status.NOT_FOUND; // 404
                break;
            case DUPLICATE:
                status = Status.CONFLICT; // 409
                break;
        }
        return Response
                .status(status)
                .entity(status.getReasonPhrase())
                .build();
    }
}
