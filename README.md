# TransFile
----------------------

Instruções de Execução
______________________

1. Modifique o arquivo `src/ClientSide/app/src/main/java/app/cliente/com/clientside/MainActivity.java`, inserindo o ip da máquina que será o servidor na variável `sock`, que se encontra na linha 32;

2. Execute o projeto do servidor que se encontra na pasta `src/ServerSide`. Um socket será criado e estará escutando na porta `13267` (sugerimos a utilização da IDE IntelliJ);

3. Conecte um dispositivo Android e execute o projeto do cliente que se encontra na pasta `src/ClientSide` (sugerimos a utilização do Android Studio). O projeto irá instalar um app que enviará um arquivo para o servidor;

4. Após instalar e antes de executar o app no seu dispositivo, verifique se o mesmo possui permissão para acessar arquivos armazenados no seu dispositivo;

5. Por fim, ao utilizar o app, um arquivo de texto que foi criado em seu dispositivo será enviado ao servidor.
