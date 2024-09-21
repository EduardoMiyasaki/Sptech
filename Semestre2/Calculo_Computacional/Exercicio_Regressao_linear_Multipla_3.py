import statsmodels.api as sm
import numpy as np
from scipy import stats
import matplotlib.pyplot as plt
import statistics as st

# Formule uma equação de regressão linear avaliando sua qualidade e buscando responder
# quantos sacos de trigo por hectare teríamos ao notar um índice pluviométrico de 9,5, 17,1
# e 6,8

precipitacao = np.array([12.9,7.2,11.3,18.6,8.8,10.3,15.9,13.1])
safraTrigo = np.array([62.5,28.7,52.2,80.6,41.6,44.5,71.3,54.4])

