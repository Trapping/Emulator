package Core;

import java.util.Objects;

public class Command {
    private String code;
    private String name;

    public Command(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public Command(){
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Command)) return false;
        Command command = (Command) o;
        return Objects.equals(getCode(), command.getCode()) &&
                Objects.equals(getName(), command.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode(), getName());
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Command{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getValue(){
        return getName() + " " + getCode();
    }
}
