package ua.kruart.traineeship;

import ua.kruart.traineeship.matcher.ModelMatcher;
import ua.kruart.traineeship.model.Role;
import ua.kruart.traineeship.model.User;
import ua.kruart.traineeship.util.UserMealsUtil;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

import static ua.kruart.traineeship.model.BaseEntity.START_SEQ;

/**Created by kruart on 27.07.2016.*/
public class UserTestData {
    public static final int USER_ID = START_SEQ;
    public static final int ADMIN_ID = START_SEQ + 1;

    public static final User USER = new User(USER_ID, "User", "user@yandex.ru", "password", Role.ROLE_USER);
    public static final User ADMIN = new User(ADMIN_ID, "Admin", "admin@gmail.com", "admin", Role.ROLE_ADMIN, Role.ROLE_USER);

    public static final ModelMatcher<User, TestUser> MATCHER = new ModelMatcher<>(u -> ((u instanceof TestUser) ? (TestUser) u : new TestUser(u)), User.class);

    public static class TestUser extends User {

        public TestUser(User u) {
            this(u.getId(), u.getName(), u.getEmail(), u.getPassword(), u.getCaloriesPerDay(), u.isEnabled(), u.getRoles());
        }

        public TestUser(String name, String email, String password, Role role, Role... roles) {
            this(null, name, email, password, UserMealsUtil.DEFAULT_CALORIES_PER_DAY, true, EnumSet.of(role, roles));
        }

        public TestUser(Integer id, String name, String email, String password, int caloriesPerDay, boolean enabled, Set<Role> roles) {
            super(id, name, email, password, caloriesPerDay, enabled, roles);
        }

        public User asUser() {
            return new User(this);
        }

        @Override
        public String toString() {
            return "User (" +
                    "id=" + id +
                    ", email=" + email +
                    ", name=" + name +
                    ", enabled=" + enabled +
                    ", password=" + password +
                    ", authorities=" + roles +
                    ')';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            TestUser that = (TestUser) o;
            return Objects.equals(this.password, that.password)
                    && Objects.equals(this.id, that.id)
                    && Objects.equals(this.name, that.name)
                    && Objects.equals(this.email, that.email)
                    && Objects.equals(this.caloriesPerDay, that.caloriesPerDay)
                    && Objects.equals(this.enabled, that.enabled);
        }
    }
}