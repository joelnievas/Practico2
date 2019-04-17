import com.sun.tools.corba.se.idl.constExpr.Or;

public class Agency implements Comparable<Agency> {
    private Address address;
    Integer agency_code;
    String correspondent_id;
    String description;
    String disabled;
    Float distance;
    String id;
    String payment_method_id;
    String phone;
    String site_id;
    String terminal;




    public static Ordenador ordenador;

    public static Ordenador getOrdenador() {
        return ordenador;
    }

    public static void setOrdenador(Ordenador ordenador) {
        Agency.ordenador = ordenador;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getAgency_code() {
        return agency_code;
    }

    public void setAgency_code(Integer agency_code) {
        this.agency_code = agency_code;
    }

    public String getCorrespondent_id() {
        return correspondent_id;
    }

    public void setCorrespondent_id(String correspondent_id) {
        this.correspondent_id = correspondent_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String isDisabled() {
        return disabled;
    }

    public void setDisabled(String disabled) {
        this.disabled = disabled;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPayment_method_id() {
        return payment_method_id;
    }

    public void setPayment_method_id(String payment_method_id) {
        this.payment_method_id = payment_method_id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSite_id() {
        return site_id;
    }

    public void setSite_id(String site_id) {
        this.site_id = site_id;
    }

    public String  isTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public Agency() {
    }

    public Agency(Address address, Integer agency_code, String correspondent_id, String description, String disabled, Float distance, String id, String payment_method_id, String phone, String site_id, String terminal) {
        this.address = address;
        this.agency_code = agency_code;
        this.correspondent_id = correspondent_id;
        this.description = description;
        this.disabled = disabled;
        this.distance = distance;
        this.id = id;
        this.payment_method_id = payment_method_id;
        this.phone = phone;
        this.site_id = site_id;
        this.terminal = terminal;
    }

    @Override
    public int compareTo(Agency o) {

        switch (ordenador){
            case ADDRESS_LINE:{
                return this.address.address_line.compareTo(o.address.address_line);
            }
            case AGENCY_CODE:{
                return this.agency_code.compareTo(o.agency_code);
            }
            case DISTANCE:{
                return this.distance.compareTo(o.distance);
            }
        }
        return 0;
    }
}
