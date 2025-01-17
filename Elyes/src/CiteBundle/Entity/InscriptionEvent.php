<?php

namespace CiteBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * InscriptionEvent
 * @ORM\Entity(repositoryClass="CiteBundle\Repository\InscriptionRepository")
 * @ORM\Table(name="inscriptionEvent", indexes={@ORM\Index(name="iduser", columns={"iduser"}),
 *     @ORM\Index(name="id_event", columns={"id_event"})
 *     })
 */
class InscriptionEvent
{
    /**
     * @var integer
     *
     * @ORM\Column(name="idinscription", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idinscription;

    /**
     * @var \Evenement
     *
     * @ORM\ManyToOne(targetEntity="Evenement")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_event", referencedColumnName="id_event")
     *
     * })
     */
    private $idevent;

    /**
     * @var \User
     *
     * @ORM\ManyToOne(targetEntity="User")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="iduser", referencedColumnName="iduser")
     * })
     */
    private $iduser;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="dateAjout", type="datetime", nullable=true)
     */
    private $dateajout = 'CURRENT_TIMESTAMP';

//------------------------------------------------------------ Getters and Setters ---------------------------------------------
    public function __construct() {
        $this->dateajout = new \DateTime();
    }

    /**
     * @return int
     */
    public function getIdinscription()
    {
        return $this->idinscription;
    }

    /**
     * @param int $idinscription
     */
    public function setIdinscription($idinscription)
    {
        $this->idinscription = $idinscription;
    }

    /**
     * @return \Evenement
     */
    public function getIdevent()
    {
        return $this->idevent;
    }

    /**
     * @param \Evenement $idevent
     */
    public function setIdevent($idevent)
    {
        $this->idevent = $idevent;
    }


    /**
     * @return \User
     */
    public function getIduser()
    {
        return $this->iduser;
    }

    /**
     * @param \User $iduser
     */
    public function setIduser($iduser)
    {
        $this->iduser = $iduser;
    }

    /**
     * @return \DateTime
     */
    public function getDateajout()
    {
        return $this->dateajout;
    }

    /**
     * @param \DateTime $dateajout
     */
    public function setDateajout($dateajout)
    {
        $this->dateajout = $dateajout;
    }
}