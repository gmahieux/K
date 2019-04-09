title: Need Hel(p)m ?
class: animation-fade
layout: true

<!-- This slide will serve as the base layout for all your slides -->

.bottom-bar[
\#DevoxxFR - @GhislainMahieux @PierreLeresteux
]

---

class: impact

# {{title}}

### REX : Helm en prod chez Saagie

.col-3[
.small[Ghislain Mahieux]
.radius[![](./images/g.jpg)]
]
.col-6[
&nbsp;&nbsp;&nbsp;
]
.col-3[
.small[Pierre Leresteux]
.radius[![](./images/image.png)]
]

---

# ATTENTION

.col-1[
&nbsp;&nbsp;&nbsp;
]
.col-10[
.center.big[
CETTE PRESNETATION N'EST PAS  
UNE PRESNETATION SUR  
KUBERNETEMSE
]

.right[
MERCI DE VOTRE  
COMPREHENSION
]
]

.col-1[
&nbsp;&nbsp;&nbsp;
]

---

# But de ce TIA

Déployer ma Super application "K" dans mon cluster Kubernetes.

- Via les commandes kubectl classiques
- Avec helm
- Need hel(p)m ?

---

# Helm

.responsive.full-width[![](./images/helm.svg)]

---

class: impact

# Démo

---

class: impact

# Need Hel(p)m ?

---

# Oui si vous avez besoin de ...

.col-6[

- Templating
- Rollback
- Packaging / Repository
- Hooks
- Automatic reload
- Conditionnal deployment
  ]
  .col-6[
  .radius.responsive.full-width[![](./images/perceval.png)]
  .small.right["Bah celui qui fait ça c'est pas la moitié d'un trou d'balle!"]
  .quote.right[\- Perceval (Livre III, L'étudiant)]
  ]

---

# Mais attention à ...

.col-6[

- Gestion des PV
- Reprise sur erreurs
- Tiller
- Release timeout
- Gestion des secrets
- Hooks

]
.col-6[
  .radius.responsive.full-width[![](./images/leodagan.png)]
  .small.right["Ma parole, des engins comme vous, ça devrait être fourni avec une notice !"]
  .quote.right[\- Léodagan (Livre I, La potion de Fécondité)]
]
---

class: impact

# Merci

.col-2[&nbsp;]
.col-3[.responsive.full-width[![](./images/sticker1.png)]]
.col-2[&nbsp;]
.col-3[.responsive.full-width[![](./images/sticker2.png)]]
.col-2[&nbsp;]


.col-12.small.italic[
(Saagie Stand S20)]

