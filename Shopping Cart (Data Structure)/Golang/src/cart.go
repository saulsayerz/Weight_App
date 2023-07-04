package main

import "fmt"

type Cart struct {
	cartItems map[string]int
}

func NewCart() *Cart {
	return &Cart{
		cartItems: make(map[string]int),
	}
}

func (c *Cart) tambahProduk(kodeProduk string, kuantitas int) {
	if currentQuantity, ok := c.cartItems[kodeProduk]; ok {
		c.cartItems[kodeProduk] = currentQuantity + kuantitas
	} else {
		c.cartItems[kodeProduk] = kuantitas
	}
}

func (c *Cart) hapusProduk(kodeProduk string) {
	delete(c.cartItems, kodeProduk)
}

func (c *Cart) tampilkanCart() {
	for kodeProduk, kuantitas := range c.cartItems {
		fmt.Printf("%s (%d)\n", kodeProduk, kuantitas)
	}
}
