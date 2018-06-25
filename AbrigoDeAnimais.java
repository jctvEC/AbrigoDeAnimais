package abrigodeanimais;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
//https://www.devmedia.com.br/como-funciona-a-classe-scanner-do-java/28448

public class AbrigoDeAnimais {

    public AbrigoDeAnimais() {        
  
    }
    
    List <Animal> listaDeAdocao = new ArrayList<>();
    Animal gatoEscolhido = new Animal(0, "Gato");
    Animal cachorroEscolhido = new Animal (0, "Cachorro");
   
    
    public void adotarAnimais() {

        Scanner escolha = new Scanner(System.in);
        int opcao = 0, contadorGato = 0, contadorCachorro = 0; 

        do{
            System.out.println("_______________________");
            System.out.println("## Escolha uma das opções abaixo ##");
            System.out.println("Opção 1 - Nos entregue um gato");
            System.out.println("Opção 2 - Nos entregue um cahorro");
            System.out.println("Opção 3 - Adotar o ultimo gato que chegou");
            System.out.println("Opção 4 - Adotar o ultimo cahorro que chegou ");
            System.out.println("Opção 5 - Adotar o ultimo animal (gato/Cachorro) que chegou");
            System.out.println("Opção 6 - Ver lista de animais");               
            System.out.println("Opção 0 - Sair do programa");
            System.out.println("_______________________");

            opcao = Integer.parseInt(escolha.nextLine());
                     

            switch(opcao){
              //cria um novo obj gato        
              case 1: // Opção 1 - Adotar um gato
                    Animal gato = new Animal (contadorGato, "Gato");  
                    enqueue(gato);
                    System.out.println("O gato " + contadorGato + " foi cadastrado com sucesso!");
                    contadorGato++;
                    break;

              case 2: //Opção 2 - Adotar um cahorro
                    Animal cachorro = new Animal (contadorCachorro, "Cachorro");
                    enqueue(cachorro);
                    System.out.println("O cachorro " + contadorCachorro + " foi cadastrado com sucesso!");
                    contadorCachorro++;
                    break;
                    
              case 3: //Opção 3 - Ver o ultimo gato que chegou 
                    Animal ultimoCat =  denqueueCat();
                    System.out.println("O primeiro gato que chegou foi o " + ultimoCat.getTipo() + " Nº... " + ultimoCat.getContador());
                    break;

              case 4://Opção 4 - Ver o ultimo cahorro que chegou 
                    Animal ultimoDog =  denqueueDog();
                    System.out.println("O primeiro cachorro que chegou foi o " + ultimoDog.getTipo() + " Nº... " + ultimoDog.getContador());
                    break;

              case 5://Opção 5 - Ver o ultimo animal (gato/Cachorro) que chegou
                    Animal ultimo =  denqueueAny();
                    System.out.println("O primeiro animal que chegou foi o ... " + ultimo.getTipo() + " Nº... " + ultimo.getContador());
                    break;

                                      
              case 6://Opção 6 - Ver lista de animais
                  printarLista();
                    break;

              default: 
                    System.out.println("Obrigado pela adoção querid@!");
                    break; 
            }

        }while (opcao != 0);
        escolha.close();
    }
    
    private  void enqueue(Animal animal){//que recebe um animal e o adiciona ao abrigo.
           listaDeAdocao.add(animal);
    }
    
    private Animal denqueueCat(){//que retorna o animal mais antigo no abrigo.
        
        Animal ultimo = null;
        int index = 0;
        if(!(listaDeAdocao.isEmpty())){
            for (Animal animal : listaDeAdocao) { 
//                System.out.println(animal.getContador());
//                System.out.println(animal.getTipo());
//               for (int i = 0; i < listaDeAdocao.size(); i++) {             
                 if (animal.getContador() == gatoEscolhido.getContador() && animal.getTipo() == gatoEscolhido.getTipo()){
                    index = listaDeAdocao.indexOf(animal);   
                    ultimo = animal;
                    listaDeAdocao.remove(index);
                    int incrementa = gatoEscolhido.getContador() + 1;
                    gatoEscolhido.setContador(incrementa);
  
                return ultimo;
               }               
            }
         }
        Animal naoTem = new Animal (-1, "Ops... Nao temos ainda... estamos saldo negativo de animais: ");
        return naoTem;
    }
    
    private Animal denqueueDog(){//que retorna o cachorro mais antigo no abrigo.
        Animal ultimo = null;
        int index = 0;
        if(!(listaDeAdocao.isEmpty())){
            for (Animal animal : listaDeAdocao) {   
//                System.out.println(animal.getContador());
//                System.out.println(animal.getTipo());
                  if (animal.getContador() == cachorroEscolhido.getContador()&&  animal.getTipo() == cachorroEscolhido.getTipo()){
                    index = listaDeAdocao.indexOf(animal);   
                    ultimo = animal;
                    listaDeAdocao.remove(index);
                    int incrementa = cachorroEscolhido.getContador() + 1;
                    cachorroEscolhido.setContador(incrementa);
                return ultimo;
               }               
            }
         }
        Animal naoTem = new Animal (-1, "Ops... Nao temos ainda... estamos saldo negativo de animais: ");
        return naoTem;
    }

    private Animal denqueueAny(){//que retorna o gato mais antigo no abrigo.
        Animal ultimo = null;
         if(!(listaDeAdocao.isEmpty())){
            for (Animal animal : listaDeAdocao) {            
                ultimo = animal;
                int index = listaDeAdocao.indexOf(animal);
                 if ("Cachorro" == (animal.getTipo())){
                    int incrementa = cachorroEscolhido.getContador() + 1;
                    listaDeAdocao.remove(index);
                    cachorroEscolhido.setContador(incrementa);
                   return ultimo;
                 }
                 else{
                    int incrementa = gatoEscolhido.getContador() + 1;
                     listaDeAdocao.remove(index);
                    gatoEscolhido.setContador(incrementa);
                      return ultimo;
                 }                         
            }                
//            return ultimo;
           }          
        Animal naoTem = new Animal (-1, "Ops... Nao temos ainda... estamos saldo negativo de animais: ");
        return naoTem;
    }
        
    
   private void printarLista(){
    if(!(listaDeAdocao.isEmpty())){
        for(Animal self : listaDeAdocao) { 
          System.out.println(self.getTipo() + " " + self.getContador());                                          
      }
    }else{
        System.out.println("Lista vazia ainda... sry...");
    }
}

 
}
