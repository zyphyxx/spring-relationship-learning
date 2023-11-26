### Principais anotações de relacionamento disponíveis no Spring Boot:

1. **@OneToOne:**
   - Anotação usada para mapear um relacionamento um-para-um entre duas entidades. Por exemplo, um usuário pode ter um único perfil, e um perfil pode estar associado a apenas um usuário.

   ```java
   @Entity
   public class Usuario {
       // ...
       @OneToOne
       @JoinColumn(name = "perfil_id")
       private Perfil perfil;
   }
   ```

2. **@OneToMany:**
   - Anotação usada para mapear um relacionamento um-para-muitos. Por exemplo, um autor pode ter vários livros, mas um livro pertence a apenas um autor.

   ```java
   @Entity
   public class Autor {
       // ...
       @OneToMany(mappedBy = "autor")
       private List<Livro> livros;
   }
   ```

3. **@ManyToOne:**
   - Anotação usada para mapear um relacionamento muitos-para-um. Por exemplo, muitos produtos podem pertencer a uma única categoria.

   ```java
   @Entity
   public class Produto {
       // ...
       @ManyToOne
       @JoinColumn(name = "categoria_id")
       private Categoria categoria;
   }
   ```

4. **@ManyToMany:**
   - Anotação usada para mapear um relacionamento muitos-para-muitos entre duas entidades. Por exemplo, um estudante pode estar matriculado em vários cursos, e um curso pode ter vários estudantes.

   ```java
   @Entity
   public class Estudante {
       // ...
       @ManyToMany
       @JoinTable(
           name = "matriculas",
           joinColumns = @JoinColumn(name = "estudante_id"),
           inverseJoinColumns = @JoinColumn(name = "curso_id")
       )
       private List<Curso> cursos;
   }
   ```

5. **@JoinColumn:**
   - Usada para especificar a coluna de junção para a associação. Pode ser usada em conjunto com `@OneToOne`, `@OneToMany`, e `@ManyToOne`.

   ```java
   @Entity
   public class Pedido {
       // ...
       @ManyToOne
       @JoinColumn(name = "cliente_id")
       private Cliente cliente;
   }
   ```

