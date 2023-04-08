package mysqlconfig.enums;

public enum ADDRESSFIELDS {
    ID("id"), NAME("name"), LAST_NAME("last_name"), PHYSICAL_ADDRESS("physical_address"),
    BIRTHDAY("birthday"),EMAIL("email");
    String fieldName;

    private ADDRESSFIELDS(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}
