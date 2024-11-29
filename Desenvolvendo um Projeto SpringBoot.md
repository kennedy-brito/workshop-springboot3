# Como criar uma entidade

Ao implementar uma entidade em SpringBoot é preciso seguir algumas regras:

1. Deve se criar seus atributos
2. A classe deve ter um construtor vazio, sem nenhum atributo como argumento.
3. Ela deve implementar os métodos ``hashCode`` e `equals`
4. Ela deve implementar a interface Serializable
5. Se possuir, também deve implementar seus relacionamentos utilizando as Collections
6. Para utiliza-la criaremos um \[__resource__]

# Como criar um resource
Um resource é um dos recursos de nossa aplicação. São eles que permitem que nosso servidor
identifique rotas. Basicamente, um resource é um controller que mapeia nossas requisições. 

Para criar um resource é necessário:
1. Definir qual classe é nosso ``Controller``. Para isso usamos uma anotação chamada ``@RestController``
    ```java
    @RestController
    public class UserResource {}
   ```
2. Definir qual a rota/url de acesso usando a anotação request mapping
    ```java
    @RestController
   //rota = "localhost:<porta>/users
    @RequestMapping(value = "/users")
    public class UserResource {}
   ```
Pronto! Agora podemos criar requisições para essa rota!

### Criando uma requisição
Para criar uma requisição precisamos definir métodos no ``Controller``

1. Defina um método que retorne uma ``ResponseEntity<T>``, onde `T` é nossa entidade:
    ```java
    @GetMapping
        public ResponseEntity<User> findAll(){
            User u = new User(1L, "Maria", "maria@gmail.com", "999999", "12345");
    
            return ResponseEntity.ok().body(u);
        }
    ```
   
Isso é somente uma representação, no corpo do método poderiamos realizar diversas operações. Processamento de dados, requisições de banco de dados, tratamento de erros, etc!

# Adicionando dependências
Um projeto Springboot pode necessitar de diversas dependências para ser concluído, afinal, ninguem faz tudo do zero! Para adicionar dependências basta usar um gerenciador de projetos.
Neste caso estarei usando maven, mas o processo é semelhante em muitos outros gerenciadores!

1. Procure no goolge ``<nome da depêndencia> maven dependency``, provavelmente o primeiro link será o correto!
2. Caso esteja em dúvida, acesse o [repositório de dependências do projeto Maven](https://mvnrepository.com/) 
3. Agora clique na sua versão escolhida e copie a marcação XML!
    ```xml
		<dependency>
			<groupId>org.springframework.data</groupId>
			<artifactId>spring-data-jpa</artifactId>
		</dependency>
    ```
4. Será algo semelhante a isso! Agora cole isso entre a tag ``dependencies``
    ```xml
   <dependencies>
   		<dependency>
			<groupId>org.springframework.data</groupId>
			<artifactId>spring-data-jpa</artifactId>
		</dependency>
   </dependencies>
   ```

5. 