# Projeto Java "Sea Our Future"

## Desenvolvimento
Projeto desenvolvido para a *Global Solution - Blue Future (Desafio Inovação Azul 2024)* proposta pela instituição de ensino *FIAP*. 

Este desafio busca ideias inovadoras e soluções tecnológicas que promovam a gestão sustentável dos oceanos. O foco é desenvolver projetos que sejam ecologicamente responsáveis, economicamente viáveis e socialmente inclusivos e inovadores.

## Desenvolvedores
_Turma: 1TDSPS_

Felipe Amador | Leonardo de Oliveira | Sara Sousa 


## Descrição do Projeto

### Sobre
O projeto Java (back-end) em si oferece funcionalidades para CRUD (Create, Read, Update, Delete) e integração com serviços externos (API) para obtenção de dados de endereços.

### Proposta
A proposta do projeto é desenvolver um sistema robusto para o gerenciamento de informações das empresas como dados primários, contato, endereço e perfil. O sistema lida com operações de banco de dados de forma eficiente e segura, bem como fornecer serviços RESTful para interação com aplicações externas.

## Componentes do Projeto

### Modelos (Models)
- **Empresa**: Representa as informações iniciais das empresas cadastradas no sistema.
- **Contato**: Representa os contatos associados às empresas.
- **Endereco**: Representa os endereços associados às empresas.
- **Perfil**: Representa os perfis associados às empresas.

### Objetos de Negócio (Business Objects - BO)
- **EmpresaBO, ContatoBO, EnderecoBO e PerfilBO**: Contém a lógica de negócios para manipulação de objetos.

### Data Access Object (DAO)
- **EmpresaDAO, ContatoDAO, EnderecoDAO e PerfilDAO**: Realiza operações de banco de dados para suas respectivas classes modelos.

### Fábrica de Conexão (Connection Factory)
- **ConexaoFactory**: Fornece métodos para estabelecer conexões com o banco de dados Oracle.

### Serviços (Services)
- **ViaCepService**: Integração com a API ViaCep para obter dados de endereços com base no CEP fornecido.

### Exceções (Exceptions)
- **EmpresaDAOException**: Trata exceções específicas do DAO de Empresa.
- **EmpresaException**: Trata exceções gerais relacionadas à Empresa.

### Recursos (Resources)
- **EmpresaResource, ContatoResource, EnderecoResource e PerfilResource**: Expõe serviços RESTful para operações de CRUD sobre as respectivas classes modelos de cada um.

## Funcionalidades
- **Gerenciamento de Empresa, Contato, Endereço e Perfil**: Cadastro, atualização, consulta e exclusão.
- **Integração com API Externa**: Consulta de endereços através da API ViaCep usando CEPs fornecidos.
- **Tratamento de Exceções**: Manuseio robusto de exceções específicas e gerais para garantir a integridade e estabilidade da aplicação.

## Tecnologias Utilizadas
- **Java**: Linguagem principal para desenvolvimento do backend;
- **JDBC**: Para interação com o banco de dados Oracle;
- **Jersey (JAX-RS)**: Para implementação de serviços RESTful;
- **Gson**: Para conversão entre objetos Java e JSON;
- **Apache HttpClient**: Para realizar requisições HTTP na integração com APIs externas;
- **Swing (JOptionPane)**: Para entrada de dados em modo desktop;
- **Oracle Database**: Banco de dados utilizado para armazenar as tabelas de Empresa, Contato, Endereco e Perfil.

## Justificativa – O Porquê do Projeto "Sea Our Future"
O projeto "Sea Our Future" tem como objetivo criar uma aplicação que gerencie informações de cadastros de empresas. Esta aplicação é uma solução B2B (Business to Business) inovadora que serve como uma ponte para conectar empresas transformadoras, que produzem produtos finais, com fornecedoras de plásticos. A intenção é facilitar e promover a reutilização de plásticos, contribuindo significativamente para a redução do acúmulo de plásticos nos oceanos.

### Razões para o Projeto

#### Sustentabilidade Ambiental
O acúmulo de plásticos nos oceanos é um problema ambiental grave que ameaça a vida marinha e os ecossistemas aquáticos. Ao facilitar a reutilização de plásticos, o projeto "Sea Our Future" ajuda a reduzir o desperdício e a poluição dos oceanos.

#### Conexão entre Empresas
Muitas empresas transformadoras precisam de fornecedores de plásticos reciclados para fabricar seus produtos. Este projeto cria uma plataforma que conecta essas empresas, simplificando a cadeia de suprimentos e promovendo práticas sustentáveis.

#### Eficiência Operacional
A aplicação oferece funcionalidades de CRUD (Create, Read, Update, Delete) para gerenciar os cadastros de empresas, tornando a gestão de dados mais eficiente e organizada. Isso facilita o acesso e a atualização de informações cruciais para o funcionamento das empresas.

#### Integração com Serviços Externos
A integração com serviços externos (API), como a API ViaCep para obtenção de dados de endereços, torna o processo de cadastro e atualização de informações mais ágil e preciso. Isso garante que os dados das empresas estejam sempre atualizados e corretos.

#### Suporte à Economia Circular
Ao promover a reutilização de plásticos, o projeto apoia a economia circular, onde os materiais são reutilizados e reciclados continuamente, reduzindo a necessidade de novos recursos e minimizando o impacto ambiental.

#### Plataforma de Negócios Inovadora
A aplicação não é apenas um sistema de gerenciamento, mas uma plataforma de negócios inovadora que facilita parcerias e colaborações entre empresas, incentivando a adoção de práticas mais ecológicas e sustentáveis.

## FRONT-END
Através do link abaixo, encontra-se o front-end da aplicação *SEA OUR FUTURE*:

https://github.com/leooli-321/Sea-Our-Future

