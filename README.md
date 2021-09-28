# dddesafio
<h1>Backend do projeto em java + spring framework</h1>

<ul>
  <li>
    spring framework para api rest
  </li>
  <li>
    flyway db para schema migration
  </li> 
  <li>
    postgresql como database
  </li>
  <li>
    postgresql como database
  </li>
  <li>
    lombok para gerar getters e setters
  </li>
<ul>

<hr />
  
  <h2>Teste os end-points</h2>
  
  <h3>end-points (retorna json)</h3>

  <h3>todos usuarios</h3>
  <a href="http://ec2-44-197-229-182.compute-1.amazonaws.com:8080/usuarios/">listar todos usuarios</a>

  <h3>todas as funcoes</h3>
  <a href="http://ec2-44-197-229-182.compute-1.amazonaws.com:8080/funcoes/">listar todas as funções</a>
  
  <h3>todas os perfis</h3>
  <a href="http://ec2-44-197-229-182.compute-1.amazonaws.com:8080/perfis/">perfis</a>

  
  <h2>Instruções para instalação</h2>
<ul>
  <li>
    1 - Gere o arquivo war com o maven: mvn package
  </li>
  <li>
    2 - acesse a pasta target e copie o arquivo com extensão .war para o diretorio webapps do seu tomcat.
  </li>
  <li>
    3 - exceute o script para criação do banco de dados: create database datainfo;
    (ententede-se que o postgres 9.5 ou superior esteja instalado).
  </li
  <li>
    4 - renomei o arquivo para ROOT.war
    execute o tomcat e acesse os end-poitns
  </li>
</ul

<hr />
  
  <h2>Caso tenha o docker/docker-compose instaldo</h2>
  
  <h3>Para facilitar o processo e agilizar a excução baixe o zip do projeto</h3>
  <ul>
    <li>
      1 - Link para os arquivos: <a href="https://drive.google.com/file/d/1kV9iugQVGe1L5FftRLbkjSzYLN9g-05P/view?usp=sharing">back-end</a>
   </li>
   <li>
     2 - extraia o arquivo e acesse a pasta.
   </li>
   <li>
     3 - excute docker-compose up -d
   </li>
  </ul>
  
