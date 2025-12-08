package functional;

public class ImmutablePerson {
    // 필드가 final 이며, 생성 후에는 상태를 변경할 수 없다. --> 변경 시 새 객체 생성
    private final String name;
    private final int age;

    public ImmutablePerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // 변경이 필요한 경우, 기존 객체를 수정하지 않고 새 객체를 반환
    public ImmutablePerson withAge(int newAge){
        return new ImmutablePerson(name, newAge);
    }

    @Override
    public String toString() {
        return "ImmutablePerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
