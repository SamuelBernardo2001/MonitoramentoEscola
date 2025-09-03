Nome do projeto: monitoramento-escolar

Visão geral:
Sistema para acompanhar o desempenho escolar. Professores lançam comportamento, desempenho, frequência e notas do aluno; geram relatórios com observações e dificuldades. Os responsáveis recebem essas informações de forma organizada e segura. Escolas/Institutos administram turmas, disciplinas, professores e alunos.

Objetivos:

Registrar dados acadêmicos e comportamentais de alunos;

Facilitar a comunicação Professor ↔ Responsável;

Gerar relatórios e histórico por período/turma/disciplina;

Disponibilizar API REST documentada (Swagger/OpenAPI) para consumo por apps/web.

Principais módulos: Aluno, Professor, Responsável, Escola/Instituto, Turma, Disciplina, Frequência, Nota, Relatório do Aluno, (futuro) Autenticação/Autorização.

Arquitetura (camadas):

Controller (API) → Service (Regras de negócio) → Repository (Persistência)

Model/Entity + DTOs + Mapper (MapStruct)

Config/Exception centralizadas

Rodando localmente (dev):

Java 21 + Maven instalados

Configure application.yml (perfil dev) com credenciais do banco (MySQL ou PostgreSQL)

mvn spring-boot:run

Swagger UI: /swagger-ui.html