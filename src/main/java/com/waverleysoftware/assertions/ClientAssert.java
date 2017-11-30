package com.waverleysoftware.assertions;

import com.waverleysoftware.model.Client;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.util.Objects;

/**
 * A simple model class for Client assert processing.
 */
public class ClientAssert extends AbstractAssert<ClientAssert, Client> {

    private static final String ERROR_MESSAGE_TEMPLATE = "\nExpecting <%s> of: \n<%s>\nto be: <%s>\nbut was: <%s>\n";

    public ClientAssert(final Client client) {
        super(client, ClientAssert.class);
    }

    public ClientAssert hasClientName(final String clientName) {
        isNotNull();

        final String name = actual.getFirstName();

        if (!Objects.areEqual(name, clientName)) {
            failWithMessage(ERROR_MESSAGE_TEMPLATE, "Client first name", actual, clientName, name);
        }
        return this;
    }

    public ClientAssert hasAge(final int clientAge) {
        isNotNull();

        final int age = actual.getAge();

        if (age != clientAge) {
            failWithMessage(ERROR_MESSAGE_TEMPLATE, "Client age", actual, clientAge, age);
        }
        return this;
    }

    public ClientAssert hasJob(final String clientJob) {
        isNotNull();

        final String job = actual.getJob();

        if (!Objects.areEqual(job, clientJob)) {
            failWithMessage(ERROR_MESSAGE_TEMPLATE, "Client job", actual, clientJob, job);
        }
        return this;
    }
}
