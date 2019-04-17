public enum Ordenador {

        ADDRESS_LINE("address_line"),
        AGENCY_CODE("agency_code"),
        DISTANCE("distance");

        private String order;

    private Ordenador(String order) {
        this.order = order;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
