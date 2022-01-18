package org.vikki;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Application {
    public static final TransactionService transactionService = new TransactionService();
    public static final ObjectMapper objectMapper = new ObjectMapper();

}
