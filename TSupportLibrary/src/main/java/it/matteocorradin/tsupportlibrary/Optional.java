package it.matteocorradin.tsupportlibrary;

public class Optional<T> {

    private T value;

    private Optional() {
        this.value = null;
    }

    private Optional(T value) {
        //this.value = Objects.requireNonNull(value);
        this.value = value;//TO SUPPORT API 16
    }

    public static<T> Optional<T> empty() {
        return new Optional<>();
    }

    public static<T> Optional<T> of(T value) {
        return new Optional<>(value);
    }

    public interface Action<T> {
        void apply(T value);
    }

    public interface VoidAction {
        void apply();
    }

    public void ifPresent(Action<T> action) {
        if (value != null) {
            action.apply(value);
        }
    }

    public void ifPresentOrNot(Action<T> action, VoidAction notPresent) {
        if (value != null) {
            action.apply(value);
        }else{
            notPresent.apply();
        }
    }

}