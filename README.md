Este projeto implementa uma Calculadora de Fórmulas abrangente, organizada em uma interface gráfica intuitiva para facilitar o acesso a diversas equações matemáticas. O aplicativo é modular, dividido em dois arquivos principais: Fórmula.java, que encapsula a lógica das fórmulas, e MainApp.java, que gerencia a interface do usuário.

A interface gráfica é composta por quatro JFrames interconectados:

- Principal: O ponto de entrada da aplicação.
- Geometria Básica: Contém fórmulas relacionadas à geometria plana.
- Geometria Espacial: Inclui fórmulas de geometria tridimensional.
- Matemática Financeira: Abriga equações financeiras.

A navegação entre os JFrames é controlada de forma transparente para o usuário por meio das variáveis de controle internas operacaoGeral e painelVisivel, garantindo uma experiência fluida. Embora as seções de fórmulas (Geometria Básica, Geometria Espacial e Matemática -  - Financeira) compartilhem uma estrutura operacional similar, cada uma é dedicada a um conjunto específico de equações.

O menu da aplicação é dinâmico, adaptando-se ao JFrame ativo e às operações disponíveis, proporcionando uma experiência de usuário contextualizada. Todas as fórmulas foram rigorosamente testadas para garantir a precisão dos cálculos.
