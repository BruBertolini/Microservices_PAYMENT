# Microservices de Pagamento - Fiap 2019



### Salvar um novo pagamento:

**Endpoint:**/save

**Exemplo:**

```
{
    id": <id>,
    "cardNumber": "<numero do cartao>",
    "expireDate": "<data de validade do cartao>",
    "operator": "<bandeira>",
    "totalValue": <valor total>
}
```

---

### Atualizar um pagamento:

**Endpoint:**/update

**Exemplo:**

```
{
    id": <id>,
    "cardNumber": "<numero do cartao>",
    "expireDate": "<data de validade do cartao>",
    "operator": "<bandeira>",
    "totalValue": <valor total>
}
```

---

### Remover um pagamento

**Endpoint:**/update/{id do pagamento}

**Exemplo:**

```
/update/4172538
```

---

### Recuperar um pagamento

**Endpoint:**/findById/{id do pagamento}

**Exemplo:**

```
/findById/4172538
```
