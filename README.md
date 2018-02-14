# Mog Backend Domain Layer

A camada de domínio é responsável por conter todas as regras de negócio. Ela pode ser consumida pela camada de 
**Application** ou servir abstrações para as demais camadas.

**OBS:** Essa camada nunca deve acessar uma implementação que não tenha sido definido nela mesma. 

Por exemplo o acesso ao banco de dados deve ser implementado na camada de **Infra** porém precisáremos de interagir de 
alguma forma com os dados que estão no banco.

Nesse cenário é papel da camada de dóminio definir uma abstração (_interface_) para o acesso a dados, e a camada de 
**Infra** deve implementa-la. Dessa forma na camada de **Domain** só precisamos conhecer a abstração. 