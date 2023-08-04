# ERP Sistemi - Muhasebe Programı

Bu proje, bir muhasebe programının temel işlevselliğini sağlayan basit bir ERP (Enterprise Resource Planning) sistemi örneğini içermektedir. Bu sistem, müşteri yönetimi, ürün yönetimi, stok takibi, ürün fiyatları ve müşteri siparişlerini yönetme yeteneklerine sahiptir. Ayrıca, müşteri siparişlerine göre fatura oluşturulur.

## Entity Yapıları

- **Customer (Müşteri):** Müşteri bilgilerini içeren entity. Müşteri ekleme, güncelleme, silme, tek müşteri getirme ve tüm müşterileri listeleme işlevleri bulunur.

- **Product (Ürün):** Ürün bilgilerini içeren entity. Ürün ekleme, güncelleme, silme, tek ürün getirme, tüm ürünleri listeleme işlevleri bulunur. Ayrıca, ürünün KDV uygulanıp uygulanmadığını belirten bir boolean alan ve KDV uygulanmamış fiyatı gibi özellikler bulunur.

- **CustomerOrder (Müşteri Siparişi):** Müşteri siparişlerini temsil eden entity. Sipariş durumları bir enum (Onay Bekliyor, Onaylandı, Kargoda, Red) şeklinde tanımlanmıştır. Sipariş onaylandığında, fatura oluşturulur.


## İşlevselliğin Genel Açıklaması

- Ürün eklenirken, ürünün KDV'ye tabii olup olmadığı ve KDV dahil fiyatı gibi bilgiler girilir.

- Ürün fiyatları güncellenebilir.

- Müşteri eklenirken temel iletişim bilgileri girilir.

- Sipariş oluşturulurken, müşteri ve ürün bilgileri ile sipariş miktarı girilir. Sipariş onaylandığında, fatura oluşturulur ve stoktan ürün miktarı düşülür.

- Kdv tablosunda Kdv değerleri saklanır.

## Kurulum ve Kullanım

1. Proje dosyalarını bilgisayarınıza indirin.
2. Gerekli bağımlılıkları yüklemek için terminali açın ve proje dizininde şu komutu çalıştırın: `npm install` veya `yarn install`.
3. Veritabanı bağlantı bilgilerini `config` dizinindeki uygun dosyalarda yapılandırın.
4. Terminalde proje dizininde şu komutu çalıştırarak uygulamayı başlatın: `npm start` veya `yarn start`.


## Katkı

Eğer projeye katkıda bulunmak isterseniz, lütfen yeni bir dal (branch) oluşturup Pull Request göndermeyi unutmayın.
