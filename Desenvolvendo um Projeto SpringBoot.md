# Como criar uma entidade

Ao implementar uma entidade em SpringBoot é preciso seguir algumas regras:

1. Deve se criar seus atributos
2. A classe deve ter um construtor vazio, sem nenhum atributo como argumento.
3. Ela deve implementar os métodos ``hashCode`` e `equals`
4. Ela deve implementar a interface Serializable
5. Se possuir, também deve implementar seus relacionamentos utilizando as Collections
6. Para utiliza-la criaremos um \[__resource__]
