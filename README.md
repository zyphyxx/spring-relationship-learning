---
### 1. **@OneToOne: Um para Um**

No relacionamento `@OneToOne`, uma entidade está associada a exatamente uma instância da outra entidade. Vamos considerar o exemplo de um autor e sua biografia.

**Author Entity:**
```java
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "biography_id", referencedColumnName = "id")
    private Biography biography;

    // Construtores, getters e setters
}
```

**Biography Entity:**
```java
@Entity
public class Biography {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    // Construtores, getters e setters
}
```

Neste exemplo, cada autor tem uma única biografia.

---
### 2. **@OneToMany: Um para Muitos**

No relacionamento `@OneToMany`, uma entidade está associada a várias instâncias da outra entidade. Vamos considerar o exemplo de um autor e seus livros.

**Author Entity:**
```java
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    private List<Book> books;

    // Construtores, getters e setters
}
```

**Book Entity:**
```java
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    // Construtores, getters e setters
}
```

Neste exemplo, um autor pode ter vários livros.

---
### 3. **@ManyToMany: Muitos para Muitos**

No relacionamento `@ManyToMany`, várias instâncias de uma entidade podem estar associadas a várias instâncias da outra entidade. Vamos considerar o exemplo de autores e seus gêneros literários.

**Author Entity:**
```java
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(
      name = "author_genre",
      joinColumns = @JoinColumn(name = "author_id"),
      inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genres;

    // Construtores, getters e setters
}
```

**Genre Entity:**
```java
@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Construtores, getters e setters
}
```

Neste exemplo, um autor pode estar associado a vários gêneros literários, e um gênero literário pode estar associado a vários autores.

### Notas Gerais:


- `@ManyToOne` e `@OneToMany` são usados juntos para representar o relacionamento bidirecional.
- `cascade = CascadeType.ALL` permite que as operações de persistência (como salvar e excluir) sejam propagadas para a entidade associada.
- `mappedBy` é usado para indicar o campo correspondente na outra entidade.
---

### 3. **@JoinTable e @JoinColumn: Muitos para Muitos**

```markdown
## Exemplo de Relacionamento Muitos-para-Muitos com JPA e Spring Boot

### Entidade `Student` (Estudante)

```java
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(
        name = "student_course",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses;

    // getters e setters
}
```

### Entidade `Course` (Curso)

```java
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    // getters e setters
}
```

### Tabela Intermediária `student_course`

O Hibernate cria automaticamente a tabela intermediária chamada "student_course". Esta tabela tem duas colunas: `student_id` e `course_id`, usadas para armazenar as relações entre estudantes e cursos.

```sql
CREATE TABLE student_course (
    student_id BIGINT,
    course_id BIGINT
);
```

Este exemplo representa um relacionamento muitos-para-muitos entre estudantes e cursos, permitindo que um estudante esteja matriculado em vários cursos e um curso tenha vários estudantes.
