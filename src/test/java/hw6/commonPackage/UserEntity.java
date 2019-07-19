// TODO commonPackage should be in the lower case
package hw6.commonPackage;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
// TODO It is better store this entity in the main source code scope
// TODO I think that here you could you @Data annotation for the object
public class UserEntity {
    private String number;
    private String user;
    private String description;

    @Override
    public int hashCode(){
        return Objects.hash(number, user, description);
    }

    @Override
    public boolean equals(Object compareObject) {
        if (compareObject == null) {
            return false;
        }
        if (this == compareObject) {
            return true;
        };
        if (!(compareObject instanceof UserEntity)) {
            return false;
        }
        UserEntity userEntity = (UserEntity) compareObject;
        return (Objects.equals(number, userEntity.number) &&
                Objects.equals(user, userEntity.user) &&
                Objects.equals(description, userEntity.description));
    }

    @Override
    public String toString(){
        return number + " " + user + " " + description;
    }
}
