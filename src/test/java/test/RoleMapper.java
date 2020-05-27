package test;

/**
 * @author jiangchen
 * @date 2020/05/26
 */
public interface RoleMapper {
    public Role getRole(Long id);

    public Role findRole(String roleName);

    public int deleteRole(Long id);

    public int insertRole(Role role);
}

