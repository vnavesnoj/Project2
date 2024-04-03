package last1k.entity.mapper;

public interface Mapper<F, T> {
    T map(F entity);
}
