USE usuario;

CREATE TABLE cadastros (
  id INT AUTO_INCREMENT PRIMARY KEY,
    nome_do_Episodio VARCHAR(30),
    NumeroEp VARCHAR(100),
    DURACAO VARCHAR(20), 
    URLRepo VARCHAR(255)
    );
    
    SELECT * FROM cadastros;
    
    ALTER TABLE cadastros
ADD COLUMN produtor VARCHAR(100);