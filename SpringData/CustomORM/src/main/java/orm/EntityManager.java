package orm;

import annotataions.Column;
import annotataions.Entity;
import annotataions.Id;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;

public class EntityManager<E> implements DbContext<E> {
    private final Connection connection;

    public EntityManager(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean persist(E entity) throws IllegalAccessException, SQLException {
        Field primaryKey = getId(entity.getClass());
        primaryKey.setAccessible(true);
        Object id = primaryKey.get(entity);

        if (id == null || (long)id <= 0) {
            return doInsert(entity, primaryKey);
        }
        return doUpdate(entity, primaryKey);
    }

    private boolean doUpdate(E entity, Field primary) {
        return false;
    }

    private boolean doInsert(E entity, Field primary) throws SQLException {
        String query = String.format("insert into %s(%s) values(%s)",
                getTableName(entity), String.join(", ",getFields(entity)), String.join(", ",getValues(entity)));

        return connection.prepareStatement(query).execute();
    }

    private String[] getFields(E entity) {
        return Arrays.stream(entity.getClass().getDeclaredFields())
                .filter(x -> !x.isAnnotationPresent(Id.class))
                .filter(x -> x.isAnnotationPresent(Column.class))
                .map(x -> x.getAnnotationsByType(Column.class))
                .map(x -> x[0].name()).toArray(String[]::new);
    }

    private String[] getValues(E entity){
        return Arrays.stream(entity.getClass().getDeclaredFields())
                .filter(x -> !x.isAnnotationPresent(Id.class))
                .filter(x -> x.isAnnotationPresent(Column.class))
                .map(x -> {
                    try {
                        x.setAccessible(true);
                        return x.get(entity);
                    } catch (IllegalAccessException e) {
                        throw new UnsupportedOperationException(e.getMessage());
                    }
                })
                .map(x-> {
                    if (x instanceof String || x instanceof LocalDate){
                        return String.format("'%s'",x.toString());
                    } else{
                        return x.toString();
                    }
                })
                .map(Object::toString)
                .toArray(String[]::new);
    }

    private String getTableName(E entity) {
        return entity.getClass().getAnnotation(Entity.class).name();
    }

    @Override
    public Iterable<E> find(Class<E> table) {
        return null;
    }

    @Override
    public Iterable<E> find(Class<E> table, String where) {
        return null;
    }

    @Override
    public E findFirst(Class<E> table) {
        return null;
    }

    @Override
    public E findFirst(Class<E> table, String where) {
        return null;
    }

    private Field getId(Class<?> entity) {
        return Arrays.stream(entity.getDeclaredFields())
                .filter(x-> x.isAnnotationPresent(Id.class))
                .findFirst()
                .orElseThrow(() -> new UnsupportedOperationException("Entity does not have id"));
    }



}
