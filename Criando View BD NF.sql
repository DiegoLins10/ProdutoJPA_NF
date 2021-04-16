CREATE VIEW v_Vendas AS
Select
n.NR,
n.DATA,
n.total as 'TOTAL NF',
(Select
CAST(SUM(TotalItem) AS DECIMAL(10,1))
From Item i2
Inner Join nota_item ni2 ON (i2.ID = ni2.itens_ID)
Where ni2.Nota_NR = ni.Nota_NR
) As 'TOTAL NF CONF.',
i.ID AS 'ID ITEM',
i.PRECOUNITARIO,
i.QUANTIDADE,
i.TOTALITEM,
p.ID AS 'ID PRODUTO',
p.NOME AS 'PRODUTO',
c.ID AS 'ID CLIENTE',
c.NOME AS 'CLIENTE'
From
nota n
Inner Join nota_item ni On (ni.Nota_NR = n.NR)
Inner Join item i ON (i.ID = ni.itens_ID)
Inner Join Produto p ON (i.PRODUTO_ID = p.ID)
Inner Join Cliente c ON (c.ID = n.CLIENTE_ID );