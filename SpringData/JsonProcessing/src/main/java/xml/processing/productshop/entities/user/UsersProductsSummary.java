package xml.processing.productshop.entities.user;

import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class UsersProductsSummary {
    private long usersCount;
    private List<UserProductsSummary> users;

    public UsersProductsSummary(List<User> users, ModelMapper mapper) {
        this.usersCount = users.size();
        this.users = users.stream().map(u -> mapper.map(u, UserProductsSummary.class)).collect(Collectors.toList());
    }

    public long getUsersCount() {
        return usersCount;
    }

    public List<UserProductsSummary> getUsers() {
        return users;
    }
}
