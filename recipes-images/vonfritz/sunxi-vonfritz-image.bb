# Small image that launches ....without a display manager

require recipes-images/angstrom/systemd-image.bb

EXTRA_IMAGE_FEATURES += "splash"

XSERVER ?= "xserver-xorg \
            xf86-video-fbturbo \
            xf86-input-evdev \
           "

IMAGE_INSTALL += " \
    xterm \
    xserver-nodm-init-systemd \
    formfactor \
    xserver-common \
    fontconfig-utils \
    ttf-dejavu-sans ttf-dejavu-sans-mono ttf-dejavu-common \
    ${XSERVER} \
    mplayer2 \
    vdr \
    vdr-plugin-softhddevice \
    "

export IMAGE_BASENAME = "sunxi-vonfritz-image"

