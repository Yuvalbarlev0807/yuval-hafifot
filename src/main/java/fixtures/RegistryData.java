package fixtures;

public record RegistryData(
        Gender gender,
        String FirstName,
        String LastName,
        String email,
        String password,
        String confirmPassword
) {
    public enum Gender {
        MALE,
        FEMALE
    }
}

