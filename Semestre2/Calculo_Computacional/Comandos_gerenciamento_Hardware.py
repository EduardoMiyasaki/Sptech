Python 3.12.5 (tags/v3.12.5:ff3bc82, Aug  6 2024, 20:45:27) [MSC v.1940 64 bit (AMD64)] on win32
Type "help", "copyright", "credits" or "license()" for more information.
import psutil

psutil.cpu_times()
scputimes(user=37424.109375, system=33490.859375, idle=2391452.390625, interrupt=2828.671875, dpc=1191.296875)
 psutil.cpu_percent(interval=1)
 
SyntaxError: unexpected indent
psutil.cpu_percent(interval=1)
0.1

psutil.cpu_percent(interval=None)
0.6
psutil.cpu_percent(interval=1, percpu=True)
[0.0, 4.6, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]
psutil.cpu_count()
12
psutil.cpu_count(logical=False)

10
len(psutil.Process().cpu_affinity())
12
psutil.cpu_stats()
scpustats(ctx_switches=3586622780, interrupts=1251777277, soft_interrupts=0, syscalls=4027152930)
psutil.cpu_freq()
scpufreq(current=1300.0, min=0.0, max=1300.0)
psutil.cpu_freq(percpu=True)
[scpufreq(current=1300.0, min=0.0, max=1300.0)]
mem = psutil.virtual_memory()
mem
svmem(total=16849293312, available=8397074432, percent=50.2, used=8452218880, free=8397074432)

psutil.swap_memory()
sswap(total=6979321856, used=160440320, free=6818881536, percent=2.3, sin=0, sout=0)

= RESTART: C:/Users/duduk/AppData/Local/Programs/Python/Python312/DesafioConjunto.py
<class 'set'>

= RESTART: C:/Users/duduk/AppData/Local/Programs/Python/Python312/DesafioConjunto.py
set()

= RESTART: C:/Users/duduk/AppData/Local/Programs/Python/Python312/DesafioConjunto.py
set()

= RESTART: C:/Users/duduk/AppData/Local/Programs/Python/Python312/DesafioConjunto.py
set()
Traceback (most recent call last):
  File "C:/Users/duduk/AppData/Local/Programs/Python/Python312/DesafioConjunto.py", line 25, in <module>
    acoesConjuntaFiltro = conjAtiva.intersecton(conjGenial , conjElite , conjNovaFutura)
AttributeError: 'set' object has no attribute 'intersecton'. Did you mean: 'intersection'?

= RESTART: C:/Users/duduk/AppData/Local/Programs/Python/Python312/DesafioConjunto.py
set()
Traceback (most recent call last):
  File "C:/Users/duduk/AppData/Local/Programs/Python/Python312/DesafioConjunto.py", line 27, in <module>
    print(acoesConjuntasFiltro)
NameError: name 'acoesConjuntasFiltro' is not defined. Did you mean: 'acoesConjuntaFiltro'?

= RESTART: C:/Users/duduk/AppData/Local/Programs/Python/Python312/DesafioConjunto.py
set()
{'CTEEP'}

= RESTART: C:/Users/duduk/AppData/Local/Programs/Python/Python312/DesafioConjunto.py
set()
{'CTEEP'}
{'BB Distribuidora'}

= RESTART: C:/Users/duduk/AppData/Local/Programs/Python/Python312/DesafioConjunto.py
set()
{'CTEEP'}
{'BB Distribuidora'}
{'Randon', 'Minerva', 'CPFL'}
{'Itaúsa', 'Banrisul', 'Sanepar', 'Engie'}
Traceback (most recent call last):
  File "C:/Users/duduk/AppData/Local/Programs/Python/Python312/DesafioConjunto.py", line 38, in <module>
    difConNovaFutura(conjAtiva , conjGenial , conjElite)
NameError: name 'difConNovaFutura' is not defined. Did you mean: 'conjNovaFutura'?


= RESTART: C:/Users/duduk/AppData/Local/Programs/Python/Python312/DesafioConjunto.py
set()
{'CTEEP'}
{'BB Distribuidora'}
{'Minerva', 'CPFL', 'Randon'}
{'Banrisul', 'Sanepar', 'Itaúsa', 'Engie'}
Traceback (most recent call last):
  File "C:/Users/duduk/AppData/Local/Programs/Python/Python312/DesafioConjunto.py", line 38, in <module>
    difConNovaFutura(conjAtiva , conjGenial , conjElite)
NameError: name 'difConNovaFutura' is not defined. Did you mean: 'conjNovaFutura'?

= RESTART: C:/Users/duduk/AppData/Local/Programs/Python/Python312/DesafioConjunto.py
set()
{'CTEEP'}
{'BB Distribuidora'}
{'Randon', 'CPFL', 'Minerva'}
{'Itaúsa', 'Banrisul', 'Engie', 'Sanepar'}
{'Gerdau', 'Vivo'}

= RESTART: C:/Users/duduk/AppData/Local/Programs/Python/Python312/DesafioConjunto.py
set()
{'CTEEP'}
{'BB Distribuidora'}
{'Randon', 'Minerva', 'CPFL'}
{'Engie', 'Itaúsa', 'Sanepar', 'Banrisul'}
{'Gerdau', 'Vivo'}
Traceback (most recent call last):
  File "C:/Users/duduk/AppData/Local/Programs/Python/Python312/DesafioConjunto.py", line 43, in <module>
    super = conjSuperNova.issuperset(conjOrama)
NameError: name 'conjSuperNova' is not defined

= RESTART: C:/Users/duduk/AppData/Local/Programs/Python/Python312/DesafioConjunto.py
set()
{'CTEEP'}
{'BB Distribuidora'}
{'Randon', 'Minerva', 'CPFL'}
{'Banrisul', 'Itaúsa', 'Sanepar', 'Engie'}
{'Vivo', 'Gerdau'}
False

= RESTART: C:/Users/duduk/AppData/Local/Programs/Python/Python312/DesafioConjunto.py
set()
{'CTEEP'}
{'BB Distribuidora'}
{'Randon', 'Minerva', 'CPFL'}
{'Banrisul', 'Sanepar', 'Itaúsa', 'Engie'}
{'Gerdau', 'Vivo'}
False
False

= RESTART: C:/Users/duduk/AppData/Local/Programs/Python/Python312/DesafioConjunto.py
set()
{'CTEEP'}
{'BB Distribuidora'}
{'Randon', 'Minerva', 'CPFL'}
{'Engie', 'Banrisul', 'Sanepar', 'Itaúsa'}
{'Gerdau', 'Vivo'}
False
False
False
False

= RESTART: C:/Users/duduk/AppData/Local/Programs/Python/Python312/DesafioConjunto.py
set()
{'CTEEP'}
{'BB Distribuidora'}
{'Randon', 'Minerva', 'CPFL'}
{'Sanepar', 'Itaúsa', 'Engie', 'Banrisul'}
{'Gerdau', 'Vivo'}
False
False
False
False

= RESTART: C:/Users/duduk/AppData/Local/Programs/Python/Python312/DesafioConjunto.py
set()
{'CTEEP'}
{'BB Distribuidora'}
{'CPFL', 'Minerva', 'Randon'}
{'Engie', 'Sanepar', 'Itaúsa', 'Banrisul'}
{'Vivo', 'Gerdau'}
False
False
False
False
Traceback (most recent call last):
  File "C:/Users/duduk/AppData/Local/Programs/Python/Python312/DesafioConjunto.py", line 58, in <module>
    conjuntoUnico = difconAtiva +  difconElite + difconGenial +  difconNovaFutura
NameError: name 'difconAtiva' is not defined. Did you mean: 'difConAtiva'?

= RESTART: C:/Users/duduk/AppData/Local/Programs/Python/Python312/DesafioConjunto.py
set()
{'CTEEP'}
{'BB Distribuidora'}
{'Minerva', 'Randon', 'CPFL'}
{'Engie', 'Sanepar', 'Banrisul', 'Itaúsa'}
{'Vivo', 'Gerdau'}
False
False
False
False
Traceback (most recent call last):
  File "C:/Users/duduk/AppData/Local/Programs/Python/Python312/DesafioConjunto.py", line 58, in <module>
    conjuntoUnico = difConAtiva +  difConElite + difConGenial +  difConNovaFutura
TypeError: unsupported operand type(s) for +: 'set' and 'set'
>>> 
= RESTART: C:/Users/duduk/AppData/Local/Programs/Python/Python312/DesafioConjunto.py
set()
{'CTEEP'}
{'BB Distribuidora'}
{'Randon', 'Minerva', 'CPFL'}
{'Sanepar', 'Engie', 'Itaúsa', 'Banrisul'}
{'Gerdau', 'Vivo'}
False
False
False
False
{'Gerdau', 'Itaúsa', 'Engie', 'Vivo', 'Minerva', 'Sanepar', 'Randon', 'CPFL', 'Banrisul', 'BB Distribuidora'}
>>> 
= RESTART: C:/Users/duduk/AppData/Local/Programs/Python/Python312/DesafioConjunto.py
set()
{'CTEEP'}
{'BB Distribuidora'}
{'CPFL', 'Randon', 'Minerva'}
{'Engie', 'Itaúsa', 'Sanepar', 'Banrisul'}
{'Vivo', 'Gerdau'}
False
False
False
False
{'Engie', 'Randon', 'Gerdau', 'Itaúsa', 'Vivo', 'Minerva', 'Sanepar', 'BB Distribuidora', 'CPFL', 'Banrisul'}
