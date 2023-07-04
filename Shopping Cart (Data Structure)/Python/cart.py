class Cart:
    def __init__(self):
        self.cart_items = {}

    def tambahProduk(self, kodeProduk, kuantitas):
        if kodeProduk in self.cart_items:
            self.cart_items[kodeProduk] += kuantitas
        else:
            self.cart_items[kodeProduk] = kuantitas

    def hapusProduk(self, kodeProduk):
        if kodeProduk in self.cart_items:
            del self.cart_items[kodeProduk]

    def tampilkanCart(self):
        for kodeProduk, kuantitas in self.cart_items.items():
            print(f"{kodeProduk} ({kuantitas})")