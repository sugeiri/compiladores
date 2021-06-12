package main

//lista simple
import (
	"fmt"
)
var (
  lista []string
)
func main()	{
	res := 0
  res= Menu()
  for ; res!=4; {
		switch res {
    case 1:
      AgregaValor()
      break
    case 2:
      fmt.Print("\n************************************\n")
      fmt.Println(lista)
      fmt.Print("\n************************************\n")
      break
    case 3:
      lista= nil
      fmt.Print("\n**LISTA BORRADA**\n")
      break
    case 4:
      return
    }
    res= Menu()
	}
}
func AgregaValor() {
  var s string 
	fmt.Println("\nIngrese Dato")
	fmt.Println("---------------------")
  fmt.Print("-> ")
	fmt.Scan(&s)
	lista = append(lista, s)
}
func Menu() int {
	var x int
	fmt.Println("\nQue Desea Hacer?")
	fmt.Println("--------------------------------------------")
  fmt.Print("1-> Agregar Valor\n2-> Ver Todos los Valores \n3->Limpiar Lista\n4-> Salir\n")
  fmt.Scan(&x)
	return x
}