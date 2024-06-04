# Probabilidad Marginal, Conjunta y Condicional

Durante 18 días se registró por la mañana si estaba o no nublado y por la tarde si llovía o no.

|                | Llueve (B) | No llueve (B') | Total |
|----------------|------------|----------------|-------|
| Nublado (A)    | 7          | 3              | 10    |
| No nublado (A')| 2          | 6              | 8     |
| Total          | 9          | 9              | 18    |

## Probabilidad Marginal

- **Probabilidad de que esté nublado:** P(A) = 9/18 = 1/2
- **Probabilidad de que no esté nublado:** P(A') = 9/18 = 1/2
- **Probabilidad de que llueva:** P(B) = 10/18 = 5/9
- **Probabilidad de que no llueva:** P(B') = 8/18 = 4/9

## Probabilidad Conjunta

- **Probabilidad de que esté nublado y llueva:** P(A∩B) = 7/18
- **Probabilidad de que no esté nublado y no llueva:** P(A'∩B') = 6/18

## Probabilidad Condicional

- **Probabilidad de que llueva dado que esté nublado:** P(B|A) = 7/9
- **Probabilidad de que llueva dado que no esté nublado:** P(B|A') = 3/9
- **Probabilidad de que no llueva dado que esté nublado:** P(B'|A) = 2/9
- **Probabilidad de que no llueva dado que no esté nublado:** P(B'|A') = 6/9
- **Probabilidad de que esté nublado dado que llueva:** P(A|B) = 7/10
- **Probabilidad de que esté nublado dado que no llueva:** P(A|B') = 2/8 = 1/4

## Bajo Independencia

|                | Llueve (B) | No llueve (B') | Total |
|----------------|------------|----------------|-------|
| Nublado (A)    | 5          | 5              | 10    |
| No nublado (A')| 4          | 4              | 8     |
| Total          | 9          | 9              | 18    |

- Las condicionales y las marginales son iguales bajo independencia.

## Teorema de Bayes

- **Probabilidad de que llueva dado que estuvo nublado:** P(llueva|nublado) = 7/9
- Esta segunda predicción es mejor, ya que involucra información adicional útil: estuvo nublado.
- Así, nuestra predicción de lluvia pasó de 5/9 a 7/9, a causa de esa nueva información.

