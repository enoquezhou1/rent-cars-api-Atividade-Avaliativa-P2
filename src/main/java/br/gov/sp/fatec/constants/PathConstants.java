package br.gov.sp.fatec.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PathConstants {
    private static final String API = "/api";

    public static final String ALUGUEL_V1 = API + "/v1/alugueis";
    public static final String ALUGUEL_ID = ALUGUEL_V1 + "/{id}";

    public static final String CARRO_V1 = API + "/v1/carros";
    public static final String CARRO_ID = CARRO_V1 + "/{id}";

    public static final String CLIENTE_V1 = API + "/v1/clientes";
    public static final String CLIENTE_ID = CLIENTE_V1 + "/{id}";
}
