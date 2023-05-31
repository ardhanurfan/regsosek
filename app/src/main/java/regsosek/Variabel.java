package regsosek;

public interface Variabel<T> {
        public String getNama();

        public void setNama(String nama);

        public String getId();

        public void setId(String id);

        public T getValue();

        public void setValue(T value);

        // public String validationError(Exception e);
        public boolean emptyError(T value);
}
